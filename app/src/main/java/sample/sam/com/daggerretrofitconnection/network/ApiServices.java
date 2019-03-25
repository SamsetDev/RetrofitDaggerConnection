package sample.sam.com.daggerretrofitconnection.network;

import retrofit2.Call;
import retrofit2.http.GET;
import sample.sam.com.daggerretrofitconnection.view.model.MoviesResponse;

/**
 * Copyright (C) DaggerRetrofitConnection - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited Proprietary and confidential.
 * <p>
 * Created by samset on 23/03/19 at 2:19 PM for DaggerRetrofitConnection .
 */


public interface ApiServices {

    @GET("movie/popular")
    Call<MoviesResponse> loadMovies();

}
