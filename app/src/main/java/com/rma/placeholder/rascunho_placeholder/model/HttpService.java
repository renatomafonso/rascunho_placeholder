package com.rma.placeholder.rascunho_placeholder.model;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.rma.placeholder.rascunho_placeholder.presentation.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import cz.msebera.android.httpclient.ProtocolException;

class HttpService extends AsyncTask<Void, Void, JSONArray> {

    public HttpService(){

    }

    protected JSONArray doInBackground(Void... voids) {
        JSONArray jsonArray = null;
        StringBuilder resposta = new StringBuilder();
        ArrayList<User> users = new ArrayList<>();
        if (true) {
            try {
                URL url = new URL("https://jsonplaceholder.typicode.com/users");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
                connection.setDoOutput(true);
                connection.setConnectTimeout(5000);
                connection.connect();
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNextLine()) {
                    resposta.append(scanner.nextLine());
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Log.i("Teste1",resposta.toString());
        try {
            jsonArray = new JSONArray(resposta.toString());
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String s = jsonObject.toString();
                users.add(new Gson().fromJson(s,User.class));
                Log.i("HttpService",s);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArray;

        //return new Gson().fromJson(resposta.toString(), User.class);
    }

}
