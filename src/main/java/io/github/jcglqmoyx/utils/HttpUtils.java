package io.github.jcglqmoyx.utils;

import okhttp3.*;

import java.io.IOException;
import java.util.Objects;

public class HttpUtils {
    private static final String URL = "http://studyxuexi.com:8085";

    public static String post(String activationCode, String OS, String machineCode) throws IOException {
        RequestBody formBody = new FormBody.Builder()
                .add("activation_code", activationCode)
                .add("os", OS)
                .add("machine_code", machineCode)
                .build();
        Response response = new OkHttpClient().newCall(new Request.Builder().url(URL).post(formBody).build()).execute();
        return Objects.requireNonNull(response.body()).string();
    }
}
