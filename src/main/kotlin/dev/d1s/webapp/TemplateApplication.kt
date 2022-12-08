/*
 * Copyright 2022 Mikhail Titov
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

package dev.d1s.webapp

import dev.d1s.webapp.component.Component
import dev.d1s.webapp.di.setupDi
import io.kvision.*
import io.kvision.core.Background
import io.kvision.core.Col
import io.kvision.core.Color
import io.kvision.core.Container
import io.kvision.panel.root
import io.kvision.utils.perc
import org.koin.core.component.KoinComponent

class TemplateApplication : Application(), KoinComponent {

    private val components by lazy {
        getKoin().getAll<Component>()
    }

    override fun start() {
        root(ROOT_ELEMENT_ID) {
            width = 100.perc
            background = Background(Color.name(Col.BLACK))

            loadComponents()
        }
    }

    private fun Container.loadComponents() {
        components.forEach {
            with(it) {
                render()
            }
        }
    }

    private companion object {

        private const val ROOT_ELEMENT_ID = "root"
    }
}

fun main() {
    setupDi()

    startApplication(
        ::TemplateApplication,
        module.hot,
        BootstrapModule,
        BootstrapCssModule,
        CoreModule
    )
}
