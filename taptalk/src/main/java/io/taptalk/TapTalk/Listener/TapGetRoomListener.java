package io.taptalk.TapTalk.Listener;

import io.taptalk.TapTalk.Interface.TapGetRoomInterface;
import io.taptalk.TapTalk.Model.TAPRoomModel;

public abstract class TapGetRoomListener implements TapGetRoomInterface {

    @Override
    public void onSuccess(TAPRoomModel room) {

    }

    @Override
    public void onError(String errorCode, String errorMessage) {

    }
}
