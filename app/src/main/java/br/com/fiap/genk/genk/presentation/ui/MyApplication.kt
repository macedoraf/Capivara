package br.com.fiap.genk.genk.presentation.ui

import android.app.Application
import android.location.LocationManager
import br.com.fiap.genk.genk.data.dagger2.component.ApplicationComponent
import javax.inject.Inject

class MyApplication : Application() {

    companion object {
        @JvmStatic
        lateinit var graph: ApplicationComponent
    }

    @Inject
    lateinit var locationManager: LocationManager


    override fun onCreate() {
        super.onCreate()
        //TODO: CRIA
    }
}