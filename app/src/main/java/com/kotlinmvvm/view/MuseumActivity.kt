package com.kotlinmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlinmvvm.R
import com.kotlinmvvm.databinding.ActivityMuseumBinding
import com.kotlinmvvm.di.Injection
import com.kotlinmvvm.model.Museum
import com.kotlinmvvm.viewmodel.MuseumViewModel


class MuseumActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMuseumBinding
    private lateinit var viewModel: MuseumViewModel
    private lateinit var adapter: MuseumAdapter


    /**
    //Consider this, if you need to call the service once when activity was created.
    Log.v(TAG,"savedInstanceState $savedInstanceState")
    if(savedInstanceState==null){
    viewModel.loadMuseums()
    }
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_museum)
        setupStatusBar()
        setupToolbar()
        setupViewModel()
        setupUI()
    }

    //status bar
    private fun setupStatusBar() {
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)
    }

    //toolbar
    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Museum Collection"
    }

    //ui
    private fun setupUI() {
        adapter = MuseumAdapter(viewModel.museums.value ?: emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    //view model
    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            Injection.provideViewModelFactory()
        ).get(MuseumViewModel::class.java)

        viewModel.museums.observe(this, renderMuseums)
        viewModel.isViewLoading.observe(this, isViewLoadingObserver)
        viewModel.onMessageError.observe(this, onMessageErrorObserver)
        viewModel.isEmptyList.observe(this, emptyListObserver)
    }

    //observers
    private val renderMuseums = Observer<List<Museum>> {
        Log.v(TAG, "data updated $it")
        binding.layoutError.visibility = View.GONE
        binding.layoutEmpty.visibility = View.GONE
        adapter.update(it)
    }

    private val isViewLoadingObserver = Observer<Boolean> {
        Log.v(TAG, "isViewLoading $it")
        val visibility = if (it) View.VISIBLE else View.GONE
        binding.progressBar.visibility = visibility
    }

    private val onMessageErrorObserver = Observer<Any> {
        Log.v(TAG, "onMessageError $it")
        binding.layoutError.visibility = View.VISIBLE
        binding.layoutEmpty.visibility = View.GONE
        binding.layoutError.findViewById<TextView>(R.id.textViewError).text = "Error $it"
    }

    private val emptyListObserver = Observer<Boolean> {
        Log.v(TAG, "emptyListObserver $it")
        binding.layoutEmpty.visibility = View.VISIBLE
        binding.layoutError.visibility = View.GONE
    }

    //If you require updated data, you can call the method "loadMuseum" here
    override fun onResume() {
        super.onResume()
        viewModel.loadMuseums()
    }

    companion object {
        const val TAG = "CONSOLE"
    }
}
