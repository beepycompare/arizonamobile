package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import retrofit2.Converter;
/* loaded from: classes5.dex */
final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    static final MediaType MEDIA_TYPE = MediaType.get("application/json; charset=UTF-8");
    private final TypeAdapter<T> adapter;
    private final Gson gson;
    private final boolean streaming;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // retrofit2.Converter
    public /* bridge */ /* synthetic */ RequestBody convert(Object obj) throws IOException {
        return convert2((GsonRequestBodyConverter<T>) obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GsonRequestBodyConverter(Gson gson, TypeAdapter<T> typeAdapter, boolean z) {
        this.gson = gson;
        this.adapter = typeAdapter;
        this.streaming = z;
    }

    @Override // retrofit2.Converter
    /* renamed from: convert  reason: avoid collision after fix types in other method */
    public RequestBody convert2(T t) throws IOException {
        if (this.streaming) {
            return new GsonStreamingRequestBody(this.gson, this.adapter, t);
        }
        Buffer buffer = new Buffer();
        writeJson(buffer, this.gson, this.adapter, t);
        return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void writeJson(BufferedSink bufferedSink, Gson gson, TypeAdapter<T> typeAdapter, T t) throws IOException {
        JsonWriter newJsonWriter = gson.newJsonWriter(new OutputStreamWriter(bufferedSink.outputStream(), StandardCharsets.UTF_8));
        typeAdapter.write(newJsonWriter, t);
        newJsonWriter.close();
    }
}
