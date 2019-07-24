package fanjie.com.takeout.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.daimajia.slider.library.SliderTypes.TextSliderView
import fanjie.com.takeout.R
import kotlinx.android.synthetic.main.item_title.view.*

/**
 * Project Name:
 * Author:wsf
 * Date: 2019/7/24 14:16
 * Notes: 首页头布局的item
 */
class HomeTitleItem(context: Context?, attrs: AttributeSet? = null) : RelativeLayout(context, attrs) {

    var url_maps: HashMap<String, String> = HashMap()

    init {
        View.inflate(context, R.layout.item_title,this)
    }

    fun bindview(s: String) {

        if (url_maps.size == 0) {
            url_maps.put("哈哈", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
            url_maps.put("呵呵", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
            url_maps.put("六六", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
            url_maps.put("么么", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

            for ((key, value) in url_maps) {
                var textSlideView: TextSliderView = TextSliderView(context)
                textSlideView.description(key).image(value)
                slider.addSlider(textSlideView)
            }
        }

    }


}