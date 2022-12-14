package com.example.youtubeapp.presentation.ui.fragments.playlists

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


import com.example.youtubeapp.domain.models.PlaylistItem
import com.example.youtubeapp.data.remote.network.Resource
import com.example.youtubeapp.data.repository.YoutubeRepository
import com.example.youtubeapp.domain.models.Playlist

class PlaylistViewModel (private var repository : YoutubeRepository) : ViewModel () {

    var localData = MutableLiveData<MutableList<PlaylistItem>>()

    fun getPlaylists(): LiveData<Resource<Playlist>> {
        return repository.getPlaylists()
    }

    fun getNextPlaylist(nextPageToken : String): LiveData<Resource<Playlist>> {
        return repository.getNextPlaylists(nextPageToken)
    }

    fun getPlaylistFromLD(){
        localData.value = repository.getPlaylist()
    }

    fun addPlaylistsToLD(list : MutableList<PlaylistItem>){
        repository.addPlaylists(list)
    }

}