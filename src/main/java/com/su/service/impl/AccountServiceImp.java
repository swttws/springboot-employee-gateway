package com.su.service.impl;

import com.su.pojo.Account;
import com.su.mapper.AccountMapper;
import com.su.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author swt 2023-12-17
 * @since 2023-12-18
 */
@Service
public class AccountServiceImp extends ServiceImpl<AccountMapper, Account> implements AccountService {

}
