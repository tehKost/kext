/*
 * Copyright (c) 2017. Jahir Fiquitiva
 *
 * Licensed under the CreativeCommons Attribution-ShareAlike
 * 4.0 International License. You may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *    http://creativecommons.org/licenses/by-sa/4.0/legalcode
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jahirfiquitiva.libs.kauextensions.ui.views

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.widget.ImageView
import jahirfiquitiva.libs.kauextensions.R

open class VerticalImageView:ImageView {

    var heightMultiplier:Float = 1.5F

    constructor(context:Context):super(context)
    constructor(context:Context, attributeSet:AttributeSet):super(context, attributeSet) {
        init(context, attributeSet)
    }

    constructor(context:Context, attributeSet:AttributeSet, defStyleAttr:Int)
            :super(context, attributeSet, defStyleAttr) {
        init(context, attributeSet)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context:Context, attributeSet:AttributeSet, defStyleAttr:Int, defStyleRes:Int)
            :super(context, attributeSet, defStyleAttr, defStyleRes) {
        init(context, attributeSet)
    }

    fun init(context:Context, attributeSet:AttributeSet) {
        val a = context.obtainStyledAttributes(attributeSet, R.styleable.VerticalImageView, 0, 0)
        try {
            heightMultiplier = a.getFloat(R.styleable.VerticalImageView_heightMultiplier, 1.5F)
        } finally {
            a.recycle()
        }
    }

    override fun onMeasure(widthMeasureSpec:Int, heightMeasureSpec:Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(measuredWidth, (measuredHeight * heightMultiplier).toInt())
    }
}