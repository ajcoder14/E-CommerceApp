package com.aniket.e_commerceapp.ui.product

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aniket.e_commerceapp.R
import com.aniket.e_commerceapp.data.repository.ProductRepository
import com.aniket.e_commerceapp.databinding.ActivityProductBinding
import com.aniket.e_commerceapp.ui.product.adapter.ColorAdapter
import com.aniket.e_commerceapp.ui.product.adapter.ImageSliderAdapter
import com.squareup.picasso.Picasso

class ProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductBinding
    private var isExpanded = false
    private var quantity = 1
    
    private val viewModel by viewModels<ProductViewModel> {
        ProductViewModelFactory(ProductRepository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.WHITE
        WindowInsetsControllerCompat(
            window,
            window.decorView
        ).isAppearanceLightStatusBars = true

        //for set UI data
        observeData()

        binding.progressBar.visibility = View.VISIBLE
        binding.llProductView.visibility = View.GONE
        viewModel.loadProduct()
    }

    private fun observeData() {

        viewModel.product.observe(this) { response ->

            binding.progressBar.visibility = View.GONE
            binding.llProductView.visibility = View.VISIBLE
            binding.tvDescription.visibility = View.GONE

            binding.tvBrand.text =
                response.data.brandName

            binding.tvTitle.text =
                response.data.name

            binding.tvSku.text =
                "SKU: ${response.data.sku}"

            binding.tvPrice.text =
                "${response.data.finalPrice} KWD"

            binding.tvDescription.text =
                HtmlCompat.fromHtml(
                    response.data.description,
                    HtmlCompat.FROM_HTML_MODE_LEGACY
                )

            binding.layoutHeader.setOnClickListener {

                isExpanded = !isExpanded

                if (isExpanded) {

                    binding.tvDescription.visibility = View.VISIBLE

                    binding.ivArrow.setImageResource(
                        R.drawable.ic_arrow_up
                    )

                } else {

                    binding.tvDescription.visibility = View.GONE

                    binding.ivArrow.setImageResource(
                        R.drawable.ic_arrow_down
                    )
                }
            }

            binding.ivBack.setOnClickListener {
                finish()
            }

            binding.ivWishlist.setOnClickListener {
                Toast.makeText(this, "Wishlist", Toast.LENGTH_SHORT).show()
            }

            binding.ivShare.setOnClickListener {
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show()
                val shareIntent = Intent(Intent.ACTION_SEND)

                shareIntent.type = "text/plain"

                shareIntent.putExtra(
                    Intent.EXTRA_TEXT,
                    "Check out this product!"
                )

                startActivity(
                    Intent.createChooser(
                        shareIntent,
                        "Share via"
                    )
                )
            }

            binding.btnAddBag.setOnClickListener{
                Toast.makeText(this, "Product added in bag", Toast.LENGTH_SHORT).show()
            }

            binding.btnShare.setOnClickListener{
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show()

                val shareIntent = Intent(Intent.ACTION_SEND)

                shareIntent.type = "text/plain"

                shareIntent.putExtra(
                    Intent.EXTRA_TEXT,
                    "Check out this product!"
                )

                startActivity(
                    Intent.createChooser(
                        shareIntent,
                        "Share via"
                    )
                )
            }

            binding.tvQuantity.text = quantity.toString()

            binding.btnPlus.setOnClickListener {

                quantity++

                binding.tvQuantity.text =
                    quantity.toString()
            }

            binding.btnMinus.setOnClickListener {

                if (quantity > 1) {

                    quantity--

                    binding.tvQuantity.text =
                        quantity.toString()
                }
            }


            //for image slider
            binding.viewPagerImages.adapter =
                ImageSliderAdapter(response.data.images)

            binding.indicator.setViewPager(binding.viewPagerImages)

            //for color adapter
            val colors =
                response.data.configurableOption[0].attributes

            binding.rvColors.layoutManager =
                LinearLayoutManager(
                    this,
                    RecyclerView.HORIZONTAL,
                    false
                )

            binding.rvColors.adapter =
                ColorAdapter(colors)

        }
    }
}