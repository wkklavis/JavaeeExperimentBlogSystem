package com.demo.vo.info;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfo {

    private Long id;

    private String nickname;

    private String avatar;


}
