package di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

/*
Initialise Koin with the modules
This should be called at the entry point to each module

android entry point is where MainActivity is in androidMain. create MyApplication file for it there
iOS entry point is MainViewController (See how its called there)
 */

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(sharedModule, platformModule)
    }
}