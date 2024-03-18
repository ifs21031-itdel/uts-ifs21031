package com.ifs21031.dinopedia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize

data class Family (var name: String,
                   var icon: Int
) : Parcelable