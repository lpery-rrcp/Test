package com.lance.library

class Book (var title:String,
            var author:String,
            var readingLevel:Number,
            var isAvailable: Boolean = true

) {
    init{
        println("Title: {$title} Author: {$author} reading Level: {$readingLevel} Availability: {$isAvailable}");
    }
}