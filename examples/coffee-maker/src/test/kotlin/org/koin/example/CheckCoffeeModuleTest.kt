package org.koin.example

import io.mockk.mockkClass
import org.junit.Rule
import org.junit.Test
import org.junit.experimental.categories.Category
import org.koin.core.annotations.scanAnnotations
import org.koin.test.KoinTest
import org.koin.test.category.CheckModuleTest
import org.koin.test.check.checkModules
import org.koin.test.mock.MockProviderRule

@Category(CheckModuleTest::class)
class CheckCoffeeModuleTest : KoinTest {

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz ->
        mockkClass(clazz, relaxed = true)
    }

    @Test
    fun checkCoffeeModule() =
        checkModules {
//            modules(coffeeAppModule)
            scanAnnotations("org.koin.example")
        }
}