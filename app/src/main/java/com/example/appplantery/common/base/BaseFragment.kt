package com.example.appplantery.common.base

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.annotation.LayoutRes
import androidx.annotation.MenuRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.appplantery.R

abstract class BaseFragment<T, P: BasePresenter>(
    @LayoutRes layoutId: Int,
    val bind: (View) -> T
) : Fragment(layoutId) {

    protected var binding: T? = null

    abstract var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if ( getMenu() !=  null) {
            setHasOptionsMenu(true)
        }
        setUpPresenter()
    }

    override fun onDestroy() {
        binding = null
        presenter.onDestroy()
        super.onDestroy()
    }

    fun OnCreateOptionsMenu(menu: Menu, inflater: MenuInflater){
        getMenu()?.let {
            inflater.inflate(it, menu)
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_notification -> {
                true
            } else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        activity?.window?.statusBarColor = ContextCompat.getColor(requireContext(), R.color.orange_dull)
        super.onViewCreated(view, savedInstanceState)
        binding = bind(view)
        setupViews()
    }

    abstract fun setupViews()

    abstract fun setUpPresenter()
    @MenuRes
    open fun getMenu(): Int? {
        return null
    }

}