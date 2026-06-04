package ru.mrlargha.feature.mobile.presentation.page.spotify.api;

import java.util.List;
import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.mrlargha.feature.mobile.presentation.page.spotify.api.obj.ArizonaSpotifyTrackResponse;
/* compiled from: SpotifyApi.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0016\b\u0001\u0010\u0006\u001a\u00020\u0007:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0006H'b\f\b\n\u0012\b\b\t\u0012\u0004\b\b(\u000bJ:\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0016\b\u0001\u0010\r\u001a\u00020\u0007:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rH'b\f\b\n\u0012\b\b\t\u0012\u0004\b\b(\u000eJ@\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u001c\b\u0001\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012H'b\f\b\n\u0012\b\b\t\u0012\u0004\b\b(\u0013¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/spotify/api/SpotifyApi;", "", "getTrackListByCategory", "Lretrofit2/Call;", "", "Lru/mrlargha/feature/mobile/presentation/page/spotify/api/obj/ArizonaSpotifyTrackResponse;", "type", "", "Lretrofit2/http/Query;", "value", "Lretrofit2/http/GET;", "client/azpotify/v1/az-spotify-v2/getByCategorie", "searchTrackListByParam", "name", "client/azpotify/v1/az-spotify-v2/search", "getTrackListByFavourites", "favouriteIdList", "", "list[]", "client/azpotify/v1/az-spotify-v2/getFavorites", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface SpotifyApi {
    @GET("client/azpotify/v1/az-spotify-v2/getByCategorie")
    Call<List<ArizonaSpotifyTrackResponse>> getTrackListByCategory(@Query("type") String str);

    @GET("client/azpotify/v1/az-spotify-v2/getFavorites")
    Call<List<ArizonaSpotifyTrackResponse>> getTrackListByFavourites(@Query("list[]") List<Integer> list);

    @GET("client/azpotify/v1/az-spotify-v2/search")
    Call<List<ArizonaSpotifyTrackResponse>> searchTrackListByParam(@Query("name") String str);
}
