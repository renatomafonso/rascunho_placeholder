package com.rma.placeholder.rascunho_placeholder.model;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.rma.placeholder.rascunho_placeholder.presentation.Presenter;

import org.json.JSONArray;

import java.util.concurrent.ExecutionException;

public class Model {

    private AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
    private Presenter presenter;

    public Model(Presenter presenter) {
        this.presenter = presenter;
    }

    public void retrieveUsers(){
        try {
            JSONArray jsonArrayUser = new HttpService().execute().get();
            presenter.giveJsonArray(jsonArrayUser);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        /*RequestParams requestParams = new RequestParams(JsonHttpUserRequest.METODO_KEY, "get-motos");
        asyncHttpClient.post(presenter.getContext(),
                JsonHttpUserRequest.URL,
                requestParams,
                new JsonHttpUserRequest(presenter));*/
    }
}
