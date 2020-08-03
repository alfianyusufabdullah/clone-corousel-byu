package alfianyabdullah.clone.byu

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class PageQuotaTransformer: ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        val resources = page.context.resources
        val nextItemVisibleMarginInPx = resources.getDimension(R.dimen.viewpager_next_item)
        val currentItemMarginInPx = resources.getDimension(R.dimen.viewpager_current_item)

        val pageTranslationX = nextItemVisibleMarginInPx + currentItemMarginInPx

        page.translationX = -pageTranslationX * position
        page.scaleY = 1 - (0.25f * abs(position))
        page.alpha = 0.8f + (1 - abs(position))
    }
}