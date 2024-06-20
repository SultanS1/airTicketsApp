package com.test.common.utils

import android.text.InputFilter
import android.text.Spanned

class KeyBoardFilter : InputFilter {
    override fun filter(
        source: CharSequence?,
        start: Int,
        end: Int,
        dest: Spanned?,
        dstart: Int,
        dend: Int
    ): CharSequence? {
        source?.let {
            for (i in start until end) {
                if (!Character.UnicodeBlock.of(it[i]).equals(Character.UnicodeBlock.CYRILLIC)) {
                    return ""
                }
            }
        }
        return null
    }
}