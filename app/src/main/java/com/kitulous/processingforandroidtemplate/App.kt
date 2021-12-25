package com.kitulous.processingforandroidtemplate

import processing.core.PApplet

object App : PApplet() {
    private var progress: Float = 0F
    private var circles: Int = 1

    override fun settings() {
        fullScreen()
    }

    override fun setup() {
        background(255)
    }

    override fun draw() {
        background(255)
        textSize(64F)
        textAlign(CENTER, CENTER)
        fill(0)
        text("Hello world", 0F, 0F, width.toFloat(), height.toFloat())

        noFill()
        stroke(0)
        strokeWeight(4F)

        for (i in 0 until circles) {
            val angle = map(progress, 0F, 1F, 0F, 360F)
            arc(width/2F, height/2F, 800F - 25F * i, 800F - 25F * i, angle, angle * (1 + 1.5F * sin(progress * 2)))
        }

        progress += 0.003F

        if (progress >= 0.2F) {
            progress = 0F
            circles++
            if (circles > 10) circles = 10
        }
    }
}