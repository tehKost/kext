/*
 * Copyright (c) 2018. Jahir Fiquitiva
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
package jahirfiquitiva.libs.kext.ui.layouts

import android.content.Context
import android.support.annotation.ColorInt
import android.support.design.widget.TabLayout
import android.util.AttributeSet
import ca.allanwang.kau.utils.tint

open class CustomTabLayout : TabLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int)
        : super(context, attributeSet, defStyleAttr)
    
    fun setTabsIconsColors(@ColorInt unselectedColor: Int, @ColorInt selectedColor: Int) {
        (0 until tabCount)
            .map { getTabAt(it) }
            .forEach { tab ->
                tab?.let {
                    if (it.isSelected) {
                        it.icon = it.icon?.tint(selectedColor)
                    } else {
                        it.icon = it.icon?.tint(unselectedColor)
                    }
                }
            }
    }
}