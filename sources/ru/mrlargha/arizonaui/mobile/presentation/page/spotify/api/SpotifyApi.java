package ru.mrlargha.arizonaui.mobile.presentation.page.spotify.api;

import java.util.List;
import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.mrlargha.arizonaui.mobile.presentation.page.spotify.api.obj.SpotifyTrackResponse;
/* compiled from: SpotifyApi.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J\u001e\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\u0007H'J$\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u000e\b\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004H'¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/spotify/api/SpotifyApi;", "", "getTrackListByCategory", "Lretrofit2/Call;", "", "Lru/mrlargha/arizonaui/mobile/presentation/page/spotify/api/obj/SpotifyTrackResponse;", "type", "", "searchTrackListByParam", "name", "getTrackListByFavourites", "favouriteIdList", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SpotifyApi {
    @GET("client/azpotify/v1/az-spotify-v2/getByCategorie")
    Call<List<SpotifyTrackResponse>> getTrackListByCategory(@Query("type") String str);

    @GET("client/azpotify/v1/az-spotify-v2/getFavorites")
    Call<List<SpotifyTrackResponse>> getTrackListByFavourites(@Query("list[]") List<Integer> list);

    @GET("client/azpotify/v1/az-spotify-v2/search")
    Call<List<SpotifyTrackResponse>> searchTrackListByParam(@Query("name") String str);
}
