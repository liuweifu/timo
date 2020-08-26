package com.linln.admin.indexpage.validator;

import lombok.Data;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;

/**
 * @author 路人
 * @date 2020/08/20
 */
@Data
public class ShowPageValid implements Serializable {
    @NotEmpty(message = "标题不能为空")
    private String title;
}