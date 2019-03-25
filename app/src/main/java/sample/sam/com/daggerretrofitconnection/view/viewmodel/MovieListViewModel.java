package sample.sam.com.daggerretrofitconnection.view.viewmodel;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import sample.sam.com.daggerretrofitconnection.network.ApiServices;
import sample.sam.com.daggerretrofitconnection.network.helper.Resource;
import sample.sam.com.daggerretrofitconnection.view.model.MovieEntity;


public class MovieListViewModel extends ViewModel {
    private final LiveData<Resource<List<MovieEntity>>> popularMovies;

    @Inject
    public MovieListViewModel(ApiServices movieRepository) {
        popularMovies = null;///movieRepository.loadPopularMovies();
    }

    LiveData<Resource<List<MovieEntity>>> getPopularMovies() {
        return popularMovies;
    }
}
