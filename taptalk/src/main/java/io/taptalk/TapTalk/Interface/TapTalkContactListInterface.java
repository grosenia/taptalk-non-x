package io.taptalk.TapTalk.Interface;

import io.taptalk.TapTalk.Model.ResponseModel.TapContactListModel;

public interface TapTalkContactListInterface {

    void onContactTapped(TapContactListModel contact);

    boolean onContactSelected(TapContactListModel contact);

    void onContactDeselected(TapContactListModel contact);

    void onMenuButtonTapped(int actionId);

    void onInfoLabelButtonTapped(int actionId);
}
