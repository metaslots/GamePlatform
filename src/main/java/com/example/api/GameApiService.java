package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RestController
public class GameApiService {

    @Autowired
    private RestTemplate restTemplate;

    private final String baseUrl = "http://external-api-url.com";

    public ResponseEntity<?> authenticate(
            @RequestParam("hash") String hash,          // 请求的哈希代码 (必需)
            @RequestParam("token") String token,        // 玩家的令牌 (必需)
            @RequestParam("providerId") String providerId,  // 游戏供应商ID (必需)
            @RequestParam(value = "gameId", required = false) String gameId, // 游戏的标识符 (可选)
            @RequestParam(value = "ipAddress", required = false) String ipAddress // 玩家的IP地址 (可选)
    ) {
        String url = baseUrl + "/authenticate";
        return restTemplate.getForEntity(url, String.class);
    }


    @GetMapping("/balance")
    public ResponseEntity<?> getBalance(
            @RequestParam("hash") String hash,          // 请求的哈希代码 (必需)
            @RequestParam("providerId") String providerId,  // 游戏供应商ID (必需)
            @RequestParam("userId") String userId,      // 娱乐场运营商系统中的用户标识符 (必需)
            @RequestParam(value = "token", required = false) String token // 通过身份验证响应提供的玩家令牌 (可选)
    ) {
        String url = baseUrl + "/balance";
        return restTemplate.getForEntity(url, String.class);
    }

    @PostMapping("/bet")
    public ResponseEntity<?> placeBet(
            @RequestParam("hash") String hash,          // 请求的哈希代码 (必需)
            @RequestParam("userId") String userId,      // 娱乐场运营商系统中的用户标识符 (必需)
            @RequestParam("gameId") String gameId,      // 游戏的ID (必需)
            @RequestParam("roundId") String roundId,    // 回合的ID (必需)
            @RequestParam("amount") BigDecimal amount,  // 下注金额，最小为0.00 (必需)
            @RequestParam("reference") String reference,// 此交易的唯一参考 (必需)
            @RequestParam("providerId") String providerId,  // 游戏供应商ID (必需)
            @RequestParam("timestamp") long timestamp,  // 时间戳 (必需)
            @RequestParam(value = "roundDetails", required = false) String roundDetails, // 用于请求的操作的详细信息 (可选)
            @RequestParam(value = "bonusCode", required = false) String bonusCode, // 如果 requestId 已被接收，则此参数将包含 bonusCode 和 requestId (可选)
            @RequestParam(value = "platform", required = false) String platform,  // 打开游戏显示的平台 (可选)
            @RequestParam(value = "language", required = false) String language,  // 打开游戏显示的语言 (可选)
            @RequestParam(value = "jackpotContribution", required = false) BigDecimal jackpotContribution, // 累积奖金贡献金额 (可选)
            @RequestParam(value = "jackpotId", required = false) String jackpotId, // 累积奖金的标识符 (可选)
            @RequestParam(value = "jackpotDetails", required = false) String jackpotDetails, // 累积奖金的详细信息 (可选)
            @RequestParam(value = "token", required = false) String token,        // 通过身份验证响应提供的玩家令牌 (可选)
            @RequestParam(value = "ipAddress", required = false) String ipAddress // 玩家的IP地址 (可选)
    ) {
        String url = baseUrl + "/bet";
        return restTemplate.postForEntity(url, null, String.class);
    }

    @GetMapping("/result")
    public ResponseEntity<?> getResult(
            @RequestParam("hash") String hash,          // 请求的哈希代码 (必需)
            @RequestParam("userId") String userId,      // 娱乐场运营商系统中的用户标识符 (必需)
            @RequestParam("gameId") String gameId,      // 游戏的ID (必需)
            @RequestParam("roundId") String roundId,    // 回合的ID (必需)
            @RequestParam("providerId") String providerId,  // 游戏供应商ID (必需)
            @RequestParam("timestamp") long timestamp,  // 时间戳 (必需)
            @RequestParam(value = "roundDetails", required = false) String roundDetails, // 用于请求的操作的详细信息 (可选)
            @RequestParam(value = "bonusCode", required = false) String bonusCode, // 如果 requestId 已被接收，则此参数将包含 bonusCode 和 requestId (可选)
            @RequestParam(value = "platform", required = false) String platform,  // 打开游戏显示的平台 (可选)
            @RequestParam(value = "token", required = false) String token,        // 通过身份验证响应提供的玩家令牌 (可选)
            @RequestParam(value = "promoWinAmount", required = false) BigDecimal promoWinAmount, // 奖金赢额 (可选)
            @RequestParam(value = "promoWinReference", required = false) String promoWinReference, // 奖金赢额参考 (可选)
            @RequestParam(value = "promoCampaignID", required = false) String promoCampaignID, // 活动ID (可选)
            @RequestParam(value = "promoCampaignType", required = false) String promoCampaignType, // 活动类型 (可选)
            @RequestParam(value = "specPrizeID", required = false) String specPrizeID, // 特殊奖品ID (可选)
            @RequestParam(value = "specPrizeValue", required = false) BigDecimal specPrizeValue, // 特殊奖品价值 (可选)
            @RequestParam(value = "specPrizeType", required = false) String specPrizeType // 特殊奖品类型 (可选)
    ) {
        String url = baseUrl + "/result";
        return restTemplate.getForEntity(url, String.class);
    }

    @GetMapping("/bonusWin")
    public ResponseEntity<?> getBonusWin(
            @RequestParam("hash") String hash,          // 请求的哈希代码 (必需)
            @RequestParam("userId") String userId,      // 娱乐场运营商系统中的用户标识符 (必需)
            @RequestParam("amount") BigDecimal amount,  // 赢奖金额 (必需)
            @RequestParam("reference") String reference,// 此交易的唯一参考 (必需)
            @RequestParam("providerId") String providerId,  // 游戏供应商ID (必需)
            @RequestParam("timestamp") long timestamp,  // 时间戳 (必需)
            @RequestParam(value = "bonusCode", required = false) String bonusCode, // 娱乐场运营商系统中的奖励ID (可选)
            @RequestParam(value = "roundId", required = false) String roundId,    // 免赞奖金相关的最后一局的游戏交易ID (可选)
            @RequestParam(value = "gameId", required = false) String gameId,      // 在免费旋转游戏中的最后一个游戏交易的游戏ID (可选)
            @RequestParam(value = "token", required = false) String token,        // 通过身份验证响应提供的玩家令牌 (可选)
            @RequestParam(value = "requestId", required = false) String requestId, // FRB 应用请求的唯一标识符 (可选)
            @RequestParam(value = "remainAmount", required = false) BigDecimal remainAmount, // 余额的剩余金额 (可选)
            @RequestParam(value = "specPrizes[0].specPrizeAmount", required = false) BigDecimal specPrizeAmount, // 玩家在累积游戏中赢得的 FRB 数量 (可选)
            @RequestParam(value = "specPrizes[0].specPrizeCode", required = false) String specPrizeCode, // PP 系统中唯一的 FRB 奖金代码 (可选)
            @RequestParam(value = "specPrizes[0].specPrizeType", required = false) String specPrizeType // 免赞特别奖金类型 (可选)
    ) {
        String url = baseUrl + "/bonusWin";
        return restTemplate.getForEntity(url, String.class);
    }

    @GetMapping("/jackpotWin")
    public ResponseEntity<?> getJackpotWin(
            @RequestParam("hash") String hash,          // 请求的哈希代码 (必需)
            @RequestParam("providerId") String providerId,  // 游戏供应商ID (必需)
            @RequestParam("timestamp") long timestamp,  // 时间戳 (必需)
            @RequestParam("userId") String userId,      // 娱乐场运营商系统中的用户标识符 (必需)
            @RequestParam("gameId") String gameId,      // 游戏的ID (必需)
            @RequestParam("roundId") String roundId,    // 游戏回合的ID (必需)
            @RequestParam("jackpotId") String jackpotId,// 累积奖金的ID (必需)
            @RequestParam(value = "jackpotDetails", required = false) String jackpotDetails, // 有关大奖的详细信息 (可选)
            @RequestParam("amount") BigDecimal amount,  // 累积奖金的赢奖金额 (必需)
            @RequestParam("reference") String reference,// 交易在Pragmatic Play系统中的唯一参考 (必需)
            @RequestParam(value = "platform", required = false) String platform,  // 游戏的平台类型 (可选)
            @RequestParam(value = "token", required = false) String token,        // 通过身份验证响应提供的玩家令牌 (可选)
            @RequestParam(value = "specPrizes[0].specPrizeType", required = false) String specPrizeType // 奖物奖品名称 (可选)
    ) {
        String url = baseUrl + "/jackpotWin";
        return restTemplate.getForEntity(url, String.class);
    }

    @PostMapping("/endRound")
    public ResponseEntity<?> endRound(
            @RequestParam("hash") String hash,          // 请求的哈希代码 (必需)
            @RequestParam("userId") String userId,      // 娱乐场运营商系统中的用户标识符 (必需)
            @RequestParam("gameId") String gameId,      // 游戏的ID (必需)
            @RequestParam("roundId") String roundId,    // 回合的ID (必需)
            @RequestParam("providerId") String providerId,  // 游戏供应商ID (必需)
            @RequestParam(value = "bonusCode", required = false) String bonusCode, // 娱乐场运营商系统中的奖励ID (可选)
            @RequestParam(value = "platform", required = false) String platform,  // 游戏的平台类型 (可选)
            @RequestParam(value = "token", required = false) String token,        // 通过身份验证响应提供的玩家令牌 (可选)
            @RequestParam(value = "roundDetails", required = false) String roundDetails, // 请求的操作的详细信息 (可选)
            @RequestParam(value = "win", required = false) BigDecimal win,        // 免赞奖金类型 (可选)
            @RequestParam(value = "specPrizes[0].specPrizeAmount", required = false) BigDecimal specPrizeAmount, // 玩家在累积游戏中赢得的 FRB 数量 (可选)
            @RequestParam(value = "specPrizes[0].specPrizeCode", required = false) String specPrizeCode, // PP 系统中唯一的 FRB 奖金代码 (可选)
            @RequestParam(value = "specPrizes[0].specPrizeType", required = false) String specPrizeType // 奖物奖品名称 (可选)
    ) {
        String url = baseUrl + "/endRound";
        return restTemplate.postForEntity(url, null, String.class);
    }

    @PostMapping("/refund")
    public ResponseEntity<?> refund(
            @RequestParam("hash") String hash,          // 请求的哈希代码 (必需)
            @RequestParam("userId") String userId,      // 娱乐场运营商系统中的用户标识符 (必需)
            @RequestParam("reference") String reference,// 退款交易的参考 (必需)
            @RequestParam("providerId") String providerId,  // 游戏供应商ID (必需)
            @RequestParam(value = "platform", required = false) String platform,  // 游戏的平台类型 (可选)
            @RequestParam(value = "amount", required = false) BigDecimal amount,  // 要退款的金额 (可选)
            @RequestParam(value = "gameId", required = false) String gameId,      // 游戏的ID (可选)
            @RequestParam(value = "roundId", required = false) String roundId,    // 回合的ID (可选)
            @RequestParam(value = "timestamp", required = false) long timestamp,  // 时间戳 (可选)
            @RequestParam(value = "roundDetails", required = false) String roundDetails, // 有关当前游戏回合的附加信息 (可选)
            @RequestParam(value = "bonusCode", required = false) String bonusCode, // 娱乐场运营商系统中的奖励ID (可选)
            @RequestParam(value = "token", required = false) String token         // 通过身份验证响应提供的玩家令牌 (可选)
    ) {
        String url = baseUrl + "/refund";
        return restTemplate.postForEntity(url, null, String.class);
    }

    @GetMapping("/getBalancePerGame")
    public ResponseEntity<?> getBalancePerGame(
            @RequestParam("hash") String hash,          // 请求的哈希代码 (必需)
            @RequestParam("userId") String userId,      // 娱乐场运营商系统中的用户标识符 (必需)
            @RequestParam("providerId") String providerId,  // 游戏供应商ID (必需)
            @RequestParam("gameIdList") String gameIdList,  // 应返回玩家余额的游戏的列表 (必需)
            @RequestParam(value = "token", required = false) String token,        // 通过身份验证响应提供的玩家令牌 (可选)
            @RequestParam(value = "platform", required = false) String platform  // 游戏的平台类型 (可选)
    ) {
        String url = baseUrl + "/getBalancePerGame";
        return restTemplate.getForEntity(url, String.class);
    }

    @GetMapping("/promoWin")
    public ResponseEntity<?> getPromoWin(
            @RequestParam("hash") String hash,          // 请求的哈希代码 (必需)
            @RequestParam("providerId") String providerId,  // 游戏供应商ID (必需)
            @RequestParam("timestamp") long timestamp,  // 时间戳 (必需)
            @RequestParam("userId") String userId,      // 娱乐场运营商系统中的用户标识符 (必需)
            @RequestParam("campaignId") String campaignId, // 活动ID (必需)
            @RequestParam("campaignType") String campaignType, // 营销活动的类型 (必需)
            @RequestParam("amount") BigDecimal amount,  // 玩家获得的奖励金额 (必需)
            @RequestParam("currency") String currency,  // 玩家货币 (必需)
            @RequestParam("reference") String reference,// 交易在Pragmatic Play系统中的唯一参考 (必需)
            @RequestParam(value = "roundId", required = false) String roundId,    // 本轮的ID (可选)
            @RequestParam(value = "gameId", required = false) String gameId,      // 游戏的ID (可选)
            @RequestParam(value = "dataType", required = false) String dataType   // 促销活动的获奖组合类型 (可选)
    ) {
        String url = baseUrl + "/promoWin";
        return restTemplate.getForEntity(url, String.class);
    }

    @GetMapping("/sessionExpired")
    public ResponseEntity<?> checkSessionExpired(
            @RequestParam(value = "hash", required = false) String hash,          // 请求的哈希代码 (可选)
            @RequestParam(value = "providerId", required = false) String providerId,  // 游戏供应商ID (可选)
            @RequestParam(value = "sessionId", required = false) String sessionId,    // 玩家在Pragmatic Play侧的游戏会话ID (可选)
            @RequestParam(value = "playerId", required = false) String playerId,      // 玩家在运营商系统中的ID (可选)
            @RequestParam(value = "token", required = false) String token             // 通过身份验证响应提供的玩家令牌 (可选)
    ) {
        String url = baseUrl + "/sessionExpired";
        return restTemplate.getForEntity(url, String.class);
    }

    @PostMapping("/adjustment")
    public ResponseEntity<?> makeAdjustment(
            @RequestParam(value = "hash", required = false) String hash,          // 请求的哈希代码 (可选)
            @RequestParam(value = "userId", required = false) String userId,      // 玩家在运营商系统中的ID (可选)
            @RequestParam(value = "gameId", required = false) String gameId,      // 游戏的ID (可选)
            @RequestParam(value = "token", required = false) String token,        // 通过身份验证响应提供的玩家令牌 (可选)
            @RequestParam(value = "roundId", required = false) String roundId,    // 回合的ID (可选)
            @RequestParam(value = "amount", required = false) BigDecimal amount,  // 要调整的金额 (可选)
            @RequestParam(value = "reference", required = false) String reference,// 交易在Pragmatic Play系统内的唯一参考 (可选)
            @RequestParam(value = "providerId", required = false) String providerId,  // 游戏供应商ID (可选)
            @RequestParam(value = "validBetAmount", required = false) BigDecimal validBetAmount, // 有效投注金额 (可选)
            @RequestParam(value = "timestamp", required = false) long timestamp   // 在Pragmatic Play一方处理交易的日期和时间 (可选)
    ) {
        String url = baseUrl + "/adjustment";
        return restTemplate.postForEntity(url, null, String.class);
    }

    @GetMapping("/roundDetails")
    public ResponseEntity<?> getRoundDetails(
            @RequestParam("hash") String hash,              // 请求的哈希代码 (必需)
            @RequestParam("userId") String userId,          // 娱乐场运营商系统中的用户标识符 (必需)
            @RequestParam("roundId") String roundId,        // 回合的ID (必需)
            @RequestParam("providerId") String providerId,  // 游戏供应商ID (必需)
            @RequestParam("smResult") String smResult,      // 老虎机或 RNG 桌面游戏结果的详细信息 (必需)
            @RequestParam("gameCategory") String gameCategory, // 游戏类别 (必需)
            @RequestParam("betMultiplier") BigDecimal betMultiplier // 投注乘数 (必需)
    ) {
        String url = baseUrl + "/roundDetails";
        return restTemplate.getForEntity(url, String.class);
    }
}
