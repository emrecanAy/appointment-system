package com.emrecan.appointmentsystem.business.concretes;

import java.util.List;

import com.emrecan.appointmentsystem.business.requests.user.CreateUserRequest;
import com.emrecan.appointmentsystem.core.utilities.mappers.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrecan.appointmentsystem.business.abstracts.UserService;
import com.emrecan.appointmentsystem.business.constants.Messages;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessDataResult;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessResult;
import com.emrecan.appointmentsystem.dataAccess.abstracts.UserDao;
import com.emrecan.appointmentsystem.entities.User;

@Service
public class UserManager implements UserService {

	private final UserDao _userDao;
	private final ModelMapperService _modelMapperService;
	
	@Autowired
	public UserManager(UserDao userDao, ModelMapperService modelMapperService) {
		this._userDao = userDao;
		this._modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<User> getById(String userId) {
		this._userDao.getUserByUserId(userId);
		return new SuccessDataResult<User>(Messages.EntityListed);
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this._userDao.getAllUsersByIsDeletedFalse(), Messages.EntitiesListed);
	}

	@Override
	public Result add(CreateUserRequest createUserRequest) {
		User user = this._modelMapperService.forRequest().map(createUserRequest, User.class);
		this._userDao.save(user);
		return new SuccessResult(Messages.EntityAdded);
	}



	
}
