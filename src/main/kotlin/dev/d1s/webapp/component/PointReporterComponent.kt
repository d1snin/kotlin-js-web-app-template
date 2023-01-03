/*
 * Copyright 2022-2023 Mikhail Titov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.d1s.webapp.component

import io.kvision.core.AlignItems
import io.kvision.core.Col
import io.kvision.core.Color
import io.kvision.core.JustifyContent
import io.kvision.html.div
import io.kvision.panel.SimplePanel
import io.kvision.panel.VPanel
import io.kvision.panel.vPanel
import io.kvision.state.ObservableValue
import io.kvision.state.bind
import io.kvision.utils.vh
import io.kvision.utils.vw
import kotlinx.browser.document
import org.koin.core.component.KoinComponent

class PointReporterComponent : Component, KoinComponent {

    override fun SimplePanel.render() {
        val observablePoint = ObservableValue(Point())

        vPanel {
            style()

            div().bind(observablePoint) { state ->
                +state.toString()
            }
        }

        document.onmousemove = {
            observablePoint.value = Point(it.x, it.y)
            asDynamic()
        }
    }

    private fun VPanel.style() {
        minHeight = 100.vh

        justifyContent = JustifyContent.CENTER
        alignItems = AlignItems.CENTER

        color = Color.name(Col.WHITE)

        fontFamily = "JetBrains Mono"
        fontSize = 7.vw
    }
}

private data class Point(
    val x: Double = .0, val y: Double = .0
)