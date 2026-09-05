package com.aether.client

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.widget.*

class MainActivity : Activity() {

    private val bg = Color.rgb(10, 10, 15)
    private val card = Color.rgb(22, 22, 30)
    private val purple = Color.rgb(135, 95, 255)
    private val white = Color.WHITE
    private val gray = Color.rgb(170, 170, 180)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showHome()
    }

    private fun createRoot(): LinearLayout {
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(28, 35, 28, 28)
            setBackgroundColor(bg)
        }
    }

    private fun addTitle(
        root: LinearLayout,
        text: String
    ) {
        root.addView(
            TextView(this).apply {
                this.text = text
                textSize = 28f
                setTextColor(white)
                typeface = Typeface.DEFAULT_BOLD
                gravity = Gravity.CENTER
                setPadding(0, 10, 0, 8)
            }
        )
    }

    private fun addSubtitle(
        root: LinearLayout,
        text: String
    ) {
        root.addView(
            TextView(this).apply {
                this.text = text
                textSize = 14f
                setTextColor(gray)
                gravity = Gravity.CENTER
                setPadding(0, 0, 0, 25)
            }
        )
    }

    private fun addButton(
        root: LinearLayout,
        text: String,
        action: () -> Unit
    ) {
        val button = Button(this).apply {
            this.text = text
            textSize = 15f
            setTextColor(white)
            setOnClickListener {
                action()
            }
        }

        root.addView(
            button,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 6, 0, 6)
            }
        )
    }

    private fun addSection(
        root: LinearLayout,
        text: String
    ) {
        root.addView(
            TextView(this).apply {
                this.text = text
                textSize = 17f
                setTextColor(purple)
                typeface = Typeface.DEFAULT_BOLD
                setPadding(4, 20, 4, 8)
            }
        )
    }

    private fun addSwitch(
        root: LinearLayout,
        text: String,
        checked: Boolean
    ) {
        root.addView(
            Switch(this).apply {
                this.text = text
                isChecked = checked
                setTextColor(white)
            }
        )
    }

    private fun showScreen(
        root: LinearLayout
    ) {
        setContentView(
            ScrollView(this).apply {
                setBackgroundColor(bg)
                addView(root)
            }
        )
    }

    private fun showHome() {

        val root = createRoot()

        addTitle(root, "AETHER CLIENT")
        addSubtitle(
            root,
            "Version 4.0.0  •  Minecraft Bedrock"
        )

        addButton(root, "▶  PLAY MINECRAFT") {
            Toast.makeText(
                this,
                "Minecraft launcher sẽ được tích hợp ở bước sau.",
                Toast.LENGTH_SHORT
            ).show()
        }

        addButton(root, "⚡  OPTIMIZATION") {
            showOptimization()
        }

        addButton(root, "⚔  PVP") {
            showPvP()
        }

        addButton(root, "▣  HUD") {
            showHud()
        }

        addButton(root, "⚙  SETTINGS") {
            showSettings()
        }

        showScreen(root)
    }

    private fun showOptimization() {

        val root = createRoot()

        addTitle(root, "OPTIMIZATION")

        addSection(root, "PERFORMANCE")

        addSwitch(root, "Smart FPS", true)
        addSwitch(root, "FPS Stabilizer", true)
        addSwitch(root, "Particle Optimization", true)
        addSwitch(root, "Animation Optimization", true)

        addSection(root, "RENDER")

        addSwitch(root, "Render Culling", false)
        addSwitch(root, "Entity Culling", false)
        addSwitch(root, "Low Effects", true)
        addSwitch(root, "Clouds", false)
        addSwitch(root, "Smooth Lighting", false)
        addSwitch(root, "Anti-Aliasing", false)

        addSection(root, "DISTANCE")

        addSwitch(root, "Low Entity Distance", true)
        addSwitch(root, "Low Render Distance", true)

        addButton(root, "←  BACK") {
            showHome()
        }

        showScreen(root)
    }

    private fun showPvP() {

        val root = createRoot()

        addTitle(root, "PVP")

        addSection(root, "HUD")

        addSwitch(root, "FPS Counter", true)
        addSwitch(root, "CPS Counter", true)
        addSwitch(root, "Ping Counter", true)
        addSwitch(root, "Coordinates", false)

        addSection(root, "PVP")

        addSwitch(root, "Hit Indicator", true)
        addSwitch(root, "Attack Indicator", true)
        addSwitch(root, "Keystrokes", false)

        addButton(root, "←  BACK") {
            showHome()
        }

        showScreen(root)
    }

    private fun showHud() {

        val root = createRoot()

        addTitle(root, "HUD")

        addSection(root, "MODULES")

        addSwitch(root, "FPS", true)
        addSwitch(root, "Ping", true)
        addSwitch(root, "CPS", true)
        addSwitch(root, "Coordinates", false)
        addSwitch(root, "Keystrokes", false)

        addSection(root, "TOUCH")

        addSwitch(root, "Touch HUD", true)
        addSwitch(root, "Large Buttons", false)

        addButton(root, "←  BACK") {
            showHome()
        }

        showScreen(root)
    }

    private fun showSettings() {

        val root = createRoot()

        addTitle(root, "SETTINGS")

        addSection(root, "AETHER CLIENT")

        addButton(root, "Version 4.0.0") {}

        addButton(root, "Minecraft Bedrock") {
            Toast.makeText(
                this,
                "Native Minecraft integration sẽ được thêm sau.",
                Toast.LENGTH_SHORT
            ).show()
        }

        addButton(root, "←  BACK") {
            showHome()
        }

        showScreen(root)
    }
}
