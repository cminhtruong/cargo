package app.el_even.com.cargo

import android.app.Application
import timber.log.Timber

/**
 * @author el_even
 * @since 2020 June 8th
 * @version 1.0
 */
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

}