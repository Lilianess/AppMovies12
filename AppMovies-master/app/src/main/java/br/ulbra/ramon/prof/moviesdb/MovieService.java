package br.ulbra.ramon.prof.moviesdb;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieService {

    private String API_KEY = "1162711f0a32afb07189bfd839506b26";

    private String API_URL = "https://api.themoviedb.org/3";

    private String METHOD_GET_POPULAR = "/movie/popular";
    private String METHOD_GET_TOPRATED = "/movie/top_rated";
    private String METHOD_GET_DETAIL = "/movie/";



    private String call(String method) throws Exception {
        String url = API_URL + method + "?api_key=" + API_KEY;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public ArrayList<Movie> getToprated() {
        ArrayList<Movie> lista = new ArrayList<>();
        try {
            String json_string = this.call(this.METHOD_GET_TOPRATED);
            JSONObject json = new JSONObject(json_string);
            JSONArray results = json.getJSONArray("results");
            int count = results.length();
            for(int i = 0; i < count; i++) {
                JSONObject obj = results.getJSONObject(i);
                Movie m = new Movie(
                    obj.getString("id"),
                    obj.getString("title"),
                    obj.getString("overview"),
                    obj.getString("poster_path")
                );
                lista.add(m);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public ArrayList<Movie> getPopular() {
        ArrayList<Movie> lista = new ArrayList<>();
        try {
            String json_string = this.call(this.METHOD_GET_POPULAR);
            JSONObject json = new JSONObject(json_string);
            JSONArray results = json.getJSONArray("results");
            int count = results.length();
            for(int i = 0; i < count; i++) {
                JSONObject obj = results.getJSONObject(i);
                Movie m = new Movie(
                        obj.getString("id"),
                        obj.getString("title"),
                        obj.getString("overview"),
                        obj.getString("poster_path")
                );
                lista.add(m);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public ArrayList<Movie>  getFavorites() {
        ArrayList<Movie> lista = new ArrayList<>();

        return lista;
    }

    public Movie getDetail(int id) {
        Movie movie = new Movie();



        return movie;
    }


}
