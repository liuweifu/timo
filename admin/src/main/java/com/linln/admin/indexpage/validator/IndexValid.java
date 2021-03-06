package com.linln.admin.indexpage.validator;

import lombok.Data;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;

/**
 * @author 小懒虫
 * @date 2020/08/19
 */
@Data
public class IndexValid implements Serializable {
    @NotEmpty(message = "标题不能为空")
    private String title;
}