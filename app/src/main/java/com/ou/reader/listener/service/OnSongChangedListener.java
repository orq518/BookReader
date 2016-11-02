package com.ou.reader.listener.service;

import android.support.v4.media.session.PlaybackStateCompat;

import com.ou.reader.listener.bean.Song;

/**
 * @author: cpacm
 * @date: 2016/7/19
 * @desciption: 歌曲变化监听器
 */
public interface OnSongChangedListener {
    void onSongChanged(Song song);

    void onPlayBackStateChanged(PlaybackStateCompat state);
}
