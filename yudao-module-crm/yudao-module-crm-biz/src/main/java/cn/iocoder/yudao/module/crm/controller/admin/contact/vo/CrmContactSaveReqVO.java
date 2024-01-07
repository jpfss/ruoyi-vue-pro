package cn.iocoder.yudao.module.crm.controller.admin.contact.vo;

import cn.iocoder.yudao.framework.common.validation.Mobile;
import cn.iocoder.yudao.framework.common.validation.Telephone;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.infra.enums.DictTypeConstants;
import com.alibaba.excel.annotation.ExcelProperty;
import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - CRM 联系人创建/更新 Request VO")
@Data
@ToString(callSuper = true)
public class CrmContactSaveReqVO  {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "3167")
    private Long id;

    @Schema(description = "姓名", example = "芋艿")
    @NotNull(message = "姓名不能为空")
    @DiffLogField(name = "姓名")
    private String name;

    @Schema(description = "客户编号", example = "10795")
    @DiffLogField(name = "姓名",function = "getCustomerById")
    private Long customerId;

    @DictFormat(cn.iocoder.yudao.module.system.enums.DictTypeConstants.USER_SEX)
    @Schema(description = "性别")
    @DiffLogField(name = "性别",function = "getSexById")
    private Integer sex;

    @Schema(description = "职位")
    @DiffLogField(name = "职位")
    private String post;

    @Schema(description = "是否关键决策人")
    @DictFormat(DictTypeConstants.BOOLEAN_STRING)
    @DiffLogField(name = "关键决策人", function = "getBooleanById")
    private Boolean master;

    @Schema(description = "直属上级", example = "23457")
    @DiffLogField(name = "直属上级",function = "getContactById")
    private Long parentId;

    @Schema(description = "手机号",example = "1387171766")
    @Mobile
    @DiffLogField(name = "手机号")
    private String mobile;

    @Schema(description = "电话",example = "021-0029922")
    @Telephone
    @DiffLogField(name = "电话")
    private String telephone;

    @Schema(description = "QQ",example = "197272662")
    @DiffLogField(name = "QQ")
    private Long qq;

    @Schema(description = "微信",example = "zzz3883")
    @DiffLogField(name = "微信")
    private String wechat;

    @Schema(description = "电子邮箱",example = "1111@22.com")
    @DiffLogField(name = "邮箱")
    @Email
    private String email;

    @Schema(description = "地区编号", example = "20158")
    @DiffLogField(name = "所在地", function = "getAreaById")
    private Integer areaId;

    @Schema(description = "地址")
    @DiffLogField(name = "地址")
    private String detailAddress;

    @Schema(description = "备注", example = "你说的对")
    @DiffLogField(name = "备注")
    private String remark;

    @Schema(description = "负责人用户编号", example = "14334")
    @NotNull(message = "负责人不能为空")
    @DiffLogField(name = "负责人",function = "getUserById")
    private Long ownerUserId;

    @Schema(description = "最后跟进时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @DiffLogField(name = "最后跟进时间")
    private LocalDateTime contactLastTime;

    @Schema(description = "下次联系时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY)
    @DiffLogField(name = "下次联系时间")
    private LocalDateTime contactNextTime;

    @Schema(description = "关联商机ID", example = "122233")
    private Long businessId;
}