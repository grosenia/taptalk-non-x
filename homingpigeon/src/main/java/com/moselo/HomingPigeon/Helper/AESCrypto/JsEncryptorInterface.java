package com.moselo.HomingPigeon.Helper.AESCrypto;

import com.evgenii.jsevaluator.interfaces.JsCallback;

public interface JsEncryptorInterface {
    public void decrypt(String text, String password, JsCallback callback);

    public void encrypt(String text, String password, JsCallback callback);

    public boolean isEncrypted(String text);
}
