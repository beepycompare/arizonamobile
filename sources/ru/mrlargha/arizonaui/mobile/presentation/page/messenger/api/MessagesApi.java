package ru.mrlargha.arizonaui.mobile.presentation.page.messenger.api;

import com.arizona.launcher.model.settings.SettingsConstants;
import java.util.List;
import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.mrlargha.arizonaui.mobile.presentation.page.messenger.api.obj.ChatMessageApiResponse;
import ru.mrlargha.arizonaui.mobile.presentation.page.messenger.api.obj.ContactApiResponse;
import ru.mrlargha.arizonaui.mobile.presentation.page.messenger.api.obj.SettingsApiResponse;
/* compiled from: MessagesApi.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0003\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\nH'JC\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\n2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\nH'¢\u0006\u0002\u0010\u000eJC\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\n2\b\b\u0003\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\nH'¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J<\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\u0015\u001a\u00020\u00072\b\b\u0003\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\nH'J,\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\u0017\u001a\u00020\n2\b\b\u0001\u0010\u0018\u001a\u00020\nH'¨\u0006\u0019À\u0006\u0003"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/api/MessagesApi;", "", "findContact", "Lretrofit2/Call;", "", "Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/api/obj/ContactApiResponse;", "token", "", SettingsConstants.NICKNAME, "limit", "", "page", "getMessages", "dialogId", "(Ljava/lang/String;IILjava/lang/Integer;)Lretrofit2/Call;", "getMessage", "(Ljava/lang/String;Ljava/lang/Integer;II)Lretrofit2/Call;", "getSettings", "Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/api/obj/SettingsApiResponse;", "getChatMessages", "Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/api/obj/ChatMessageApiResponse;", "contactId", "getContactInfo", "id", "tel", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface MessagesApi {
    @GET("contacts")
    Call<List<ContactApiResponse>> findContact(@Header("Authorization") String str, @Query("query") String str2, @Query("limit") int i, @Query("page") int i2);

    @GET("chats/{id}/messages")
    Call<List<ChatMessageApiResponse>> getChatMessages(@Header("Authorization") String str, @Path("id") String str2, @Query("limit") int i, @Query("page") int i2);

    @GET("contact/{id}")
    Call<ContactApiResponse> getContactInfo(@Header("Authorization") String str, @Path("id") int i, @Query("tel") int i2);

    @GET("chats")
    Call<List<ContactApiResponse>> getMessage(@Header("Authorization") String str, @Query("id") Integer num, @Query("limit") int i, @Query("page") int i2);

    @GET("chats")
    Call<List<ContactApiResponse>> getMessages(@Header("Authorization") String str, @Query("limit") int i, @Query("page") int i2, @Query("id") Integer num);

    @GET("config")
    Call<SettingsApiResponse> getSettings(@Header("Authorization") String str);

    /* compiled from: MessagesApi.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
    }

    static /* synthetic */ Call findContact$default(MessagesApi messagesApi, String str, String str2, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                str2 = null;
            }
            if ((i3 & 4) != 0) {
                i = 20;
            }
            if ((i3 & 8) != 0) {
                i2 = 1;
            }
            return messagesApi.findContact(str, str2, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findContact");
    }

    static /* synthetic */ Call getMessages$default(MessagesApi messagesApi, String str, int i, int i2, Integer num, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 20;
            }
            if ((i3 & 4) != 0) {
                i2 = 1;
            }
            if ((i3 & 8) != 0) {
                num = null;
            }
            return messagesApi.getMessages(str, i, i2, num);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMessages");
    }

    static /* synthetic */ Call getMessage$default(MessagesApi messagesApi, String str, Integer num, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                num = null;
            }
            if ((i3 & 4) != 0) {
                i = 1;
            }
            if ((i3 & 8) != 0) {
                i2 = 1;
            }
            return messagesApi.getMessage(str, num, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMessage");
    }

    static /* synthetic */ Call getChatMessages$default(MessagesApi messagesApi, String str, String str2, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                i = 20;
            }
            if ((i3 & 8) != 0) {
                i2 = 1;
            }
            return messagesApi.getChatMessages(str, str2, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getChatMessages");
    }
}
