package DesignMode.Builder;

import java.net.http.HttpClient;

/**
 * @author Administrator
 * @Date 2025/9/4 17:30
 * @package DesignMode.Builder
 * @Description:
 */
public class User {
    // 必选属性
    private final String id;
    private final String username;

    // 可选属性
    private final String nickname;
    private final Integer age;
    private final String email;

    // 私有构造器，仅允许内部Builder调用
    private User(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.nickname = builder.nickname;
        this.age = builder.age;
        this.email = builder.email;
    }
    public static  Builder builder(String id,String username){
        return  new Builder(id,username);
    }

    // Getter方法（无setter，保证对象不可变）
    public String getId() { return id; }
    public String getUsername() { return username; }
    public String getNickname() { return nickname; }
    public Integer getAge() { return age; }
    public String getEmail() { return email; }

    // 静态内部Builder类
    public static class Builder {
        // 必选属性（在构造器中初始化）
        private final String id;
        private final String username;

        // 可选属性（默认值为null或默认值）
        private String nickname;
        private Integer age;
        private String email;

        // Builder构造器：仅接收必选参数
        public Builder(String id, String username) {
            this.id = id;
            this.username = username;
        }

        // 可选属性的链式设置方法（返回Builder自身）
        public Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }
        public Builder age(Integer age) {
            this.age = age;
            return this;
        }
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        // 构建产品实例
        public User build() {
            // 可在此处添加参数校验
            if (id == null || id.isEmpty()) {
                throw new IllegalArgumentException("id不能为空");
            }
            return new User(this);
        }
    }
}

