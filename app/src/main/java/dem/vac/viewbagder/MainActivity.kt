package dem.vac.viewbagder

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.view.animation.ScaleAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.readystatesoftware.viewbadger.BadgeView

class MainActivity : AppCompatActivity() {

    private lateinit var tvshow: TextView
    private lateinit var edtinput: EditText
    private lateinit var btn1: Button
    private lateinit var btn2: Button

    private lateinit var rotaanimation: RotateAnimation
    private lateinit var scaleanimation: ScaleAnimation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //旋转动画
        rotaanimation = RotateAnimation(
            0f, 360f,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotaanimation.duration = 1000

        //缩放动画
        scaleanimation = ScaleAnimation(
            1f, 3f, 1f, 3f,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
        )
        scaleanimation.duration = 100
        scaleanimation.repeatMode = Animation.REVERSE
        scaleanimation.repeatCount = 1


        //TextView
        tvshow = findViewById(R.id.tvshow)
        BadgeViewUtil.build(this, tvshow)
            .setText("新消息")
            .setPosition(BadgeView.POSITION_CENTER)
            .show()
        tvshow.setOnClickListener {
            BadgeViewUtil.build(this, tvshow)
                .toggle(rotaanimation)
        }

        //EditText
        edtinput = findViewById(R.id.edtinput)
        BadgeViewUtil.build(this, edtinput)
            .setText("Hello")
            .setColor(Color.CYAN, Color.LTGRAY)
            .setPosition(BadgeView.POSITION_TOP_LEFT)
            .toggle(rotaanimation)

        //Button1
        btn1 = findViewById(R.id.btn1)
        BadgeViewUtil.build(this, btn1)
            .setColor(Color.BLACK, Color.YELLOW)
            .increment(0)
        btn1.setOnClickListener {
            BadgeViewUtil.build(this, btn1)
                .increment().show(scaleanimation)
        }

        //Button2
        btn2 = findViewById(R.id.btn2)
        BadgeViewUtil.build(this, btn2)
            .setText("10")
            .setBadgeMargin(5)
            .show(scaleanimation)
        btn2.setOnClickListener {
            var str = BadgeViewUtil.build(this, btn2)
                .decrement().getText()
            btn2.text = str
        }
    }
}
