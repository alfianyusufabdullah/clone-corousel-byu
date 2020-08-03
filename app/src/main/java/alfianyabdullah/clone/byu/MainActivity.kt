package alfianyabdullah.clone.byu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animationUtils = AnimationUtils()
        animationUtils.setTargetView(ivLine)

        pageQuota.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                animationUtils.playAnimation()
            }
        })

        pageQuota.addItemDecoration(PageQuotaItemDecoration(this, R.dimen.viewpager_current_item))
        pageQuota.setPageTransformer(PageQuotaTransformer())
        pageQuota.offscreenPageLimit = DataManager.quotas.size
        pageQuota.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        pageQuota.adapter = QuotaAdapter()

        TabLayoutMediator(pageQuotaIndicator, pageQuota) { _, _ -> }.attach()
    }
}