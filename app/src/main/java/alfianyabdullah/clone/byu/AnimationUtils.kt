package alfianyabdullah.clone.byu

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View

class AnimationUtils {

    private lateinit var target: View

    fun setTargetView(attachedView: View) {
        target = attachedView
    }

    fun playAnimation(){
        if (!this::target.isInitialized) throw IllegalAccessError("Target not initialized, be sure setTargetView() called")

        val animators = listOf(
            animationBuilder(0.7f, -30f),
            animationBuilder(0.9f, 90f),
            animationBuilder(0.8f, 120f),
            animationBuilder(0.6f, 100f),
            animationBuilder(1f, 450f),
            animationBuilder(0.7f, 100f)
        )

        animators[(0..animators.lastIndex).random()].start()
    }

    private fun animationBuilder(scaleValue: Float, rotation: Float): AnimatorSet {
        val rotationAnimation = ObjectAnimator.ofFloat(target, "rotation", rotation)
        val scaleXAnimation = ObjectAnimator.ofFloat(target, "scaleX", scaleValue)
        val scaleYAnimation = ObjectAnimator.ofFloat(target, "scaleY", scaleValue)

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(rotationAnimation, scaleXAnimation, scaleYAnimation)
        return animatorSet
    }
}