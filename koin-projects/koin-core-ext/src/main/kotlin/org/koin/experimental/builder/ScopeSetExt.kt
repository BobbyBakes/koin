/*
 * Copyright 2017-2021 the original author or authors.
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
package org.koin.experimental.builder

import org.koin.core.definition.BeanDefinition
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.ScopeDSL

/**
 * Create a Single definition for given type T
 * @param qualifier
 * @param override - allow definition override
 */
inline fun <reified T : Any> ScopeDSL.scoped(
        qualifier: Qualifier? = null,
        override: Boolean = false
): BeanDefinition<T> {
    return scoped(qualifier, override) { create<T>() }
}

/**
 * Create a Factory definition for given type T
 *
 * @param qualifier
 * @param override - allow definition override
 */
inline fun <reified T : Any> ScopeDSL.factory(
        qualifier: Qualifier? = null,
        override: Boolean = false
): BeanDefinition<T> {
    return factory(qualifier, override) { create<T>() }
}

/**
 * Create a Single definition for given type T to modules and cast as R
 * @param qualifier
 * @param override - allow definition override
 */
inline fun <reified R : Any, reified T : R> ScopeDSL.scopedBy(
        qualifier: Qualifier? = null,
        override: Boolean = false
): BeanDefinition<R> {
    return scoped(qualifier, override) { create<T>() as R }
}

/**
 * Create a Factory definition for given type T to modules and cast as R
 *
 * @param qualifier
 * @param override - allow definition override
 */
inline fun <reified R : Any, reified T : R> ScopeDSL.factoryBy(
        qualifier: Qualifier? = null,
        override: Boolean = false
): BeanDefinition<R> {
    return factory(qualifier, override) { create<T>() as R }
}