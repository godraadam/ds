package dev.godraadam.dsassingment.api.rpc;

import java.util.List;

import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;

@JsonRpcService("/api/rpc")
public interface RpcController {

    List<Double> getPastNDaysBaseline(@JsonRpcParam(value = "userId") Long userId,
                                        @JsonRpcParam(value = "numberOfDays") Long numberOfDays);

    List<Double> getPast7DaysBaseline(@JsonRpcParam(value = "userId") Long userId);
    List<Double> getEstimation(@JsonRpcParam(value = "interval") Long interval,
                                @JsonRpcParam(value = "deviceId") Long deviceId);
}
