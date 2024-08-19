package com.jo2.server.auth.strategy;

import com.jo2.server.auth.social.SocialType;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class SignInStrategyManager {
    private final Map<SocialType, SignInStrategy> loginStrategies;

    public SignInStrategyManager(final List<SignInStrategy> strategies) {
        this.loginStrategies = strategies.stream().collect(Collectors.toMap(SignInStrategy::getSocialType, Function.identity()));
    }

    public SignInStrategy getLoginStrategy(final SocialType socialType) {
        return loginStrategies.get(socialType);
    }
}
