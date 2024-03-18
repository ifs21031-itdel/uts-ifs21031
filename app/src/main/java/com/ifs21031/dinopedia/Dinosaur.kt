package com.ifs21031.dinopedia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize

    data class Dinosaur (var name: String,
                         var icon: Int,
                         var family: String,
                         var description: String,
                         var lifeLength: String,
                         var characteristic: String,
                         var habitat: String,
                         var habit: String,
                         var classDino: String,
    ) : Parcelable