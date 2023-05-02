package com.trail.contoller;

import com.trail.model.Mobile;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
public class ResponseDTO {

    private List<ResponseData> phoneFinalList;
}
