package dem.vac.viewbagder

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.animation.Animation
import com.readystatesoftware.viewbadger.BadgeView

/**
 * 作者：Vaccae
 * 邮箱：3657447@qq.com
 * 创建时间：2019-12-24 10:49
 * 功能模块说明：
 */
object BadgeViewUtil {
    private val TAG = "badgeview"
    //定义存在的集合
    private val badgeviewlist = ArrayList<BadgeView>()
    //当前操作的badgeView
    private lateinit var badgeView: BadgeView

    //获取当前的badgeview方法
    private fun getBadgeView(context: Context, view: View) {
        try {
            badgeView = badgeviewlist.first { it.target == view }
            Log.i(TAG, "text:" + badgeView.text.toString())
        } catch (e: Exception) {
            Log.i(TAG, e.message.toString())
            badgeView = BadgeView(context, view)
            badgeviewlist.add(badgeView)
        }
    }

    //创建badgeView
    fun build(context: Context, view: View): BadgeViewUtil {
        getBadgeView(context, view)
        return BadgeViewUtil
    }

    //设置文字
    fun setText(title: String):BadgeViewUtil {
        badgeView.text = title
        return BadgeViewUtil
    }

    //设置字体大小
    fun setTextSize(size: Float): BadgeViewUtil {
        badgeView.setTextSize(size)
        return BadgeViewUtil
    }

    //设置位置微调
    fun setBadgeMargin(size: Int = 2): BadgeViewUtil {
        badgeView.setBadgeMargin(2)
        return BadgeViewUtil
    }

    fun setBadgeMargin(size: Int, size2: Int): BadgeViewUtil {
        badgeView.setBadgeMargin(size, size2)
        return BadgeViewUtil
    }

    //设置颜色
    fun setColor(
        textcolor: Int = Color.WHITE,
        bgcolor: Int = Color.RED
    ): BadgeViewUtil {
        //设置文本颜色
        badgeView.setTextColor(textcolor)
        //设置背景颜色
        badgeView.badgeBackgroundColor = bgcolor
        return BadgeViewUtil
    }

    //设置位置
    fun setPosition(position: Int = BadgeView.POSITION_TOP_RIGHT): BadgeViewUtil {
        badgeView.badgePosition = position
        return BadgeViewUtil
    }

    //计数加一
    fun increment(offset: Int = 1): BadgeViewUtil {
        badgeView.increment(offset)
        return BadgeViewUtil
    }

    //计数减一
    fun decrement(offset: Int = 1): BadgeViewUtil {
        badgeView.decrement(offset)
        if (badgeView.text == "0") {
            badgeView.hide()
        }
        return BadgeViewUtil
    }

    //修改当前状态,如果显示则隐藏，如果隐藏则显示
    fun toggle(animation: Animation? = null) {
        if (animation == null) badgeView.toggle()
        else badgeView.toggle(animation, animation)
    }

    //显示
    fun show(animation: Animation? = null) {
        if (animation == null) badgeView.show()
        else badgeView.show(animation)
    }

    //隐藏
    fun hide(animation: Animation? = null) {
        if (animation == null) badgeView.hide()
        else badgeView.hide(animation)
    }

    //获取文本
    fun getText(): String {
        return badgeView.text.toString()
    }

}