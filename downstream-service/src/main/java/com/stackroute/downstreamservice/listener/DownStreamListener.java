package com.stackroute.downstreamservice.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

import com.stackroute.downstreamservice.model.AcademicQualification;
import com.stackroute.downstreamservice.model.Certificates;
import com.stackroute.downstreamservice.model.Experience;
import com.stackroute.downstreamservice.model.Location;
import com.stackroute.downstreamservice.model.PersonalInfo;
import com.stackroute.downstreamservice.model.Projects;
import com.stackroute.downstreamservice.model.Skills;
import com.stackroute.downstreamservice.model.User;
import com.stackroute.downstreamservice.repository.UserRepository;
import com.stackroute.downstreamservice.stream.AcademiesStream;
import com.stackroute.downstreamservice.stream.ExperienceStream;
import com.stackroute.downstreamservice.stream.LocationStream;
import com.stackroute.downstreamservice.stream.PersonalInfoStream;
import com.stackroute.downstreamservice.stream.ProjectStream;
import com.stackroute.downstreamservice.stream.SkillsStream;
import com.stackroute.downstreamservice.stream.TrainingStream;
import com.stackroute.downstreamservice.stream.UserStream;

import lombok.NoArgsConstructor;

/**
 * 
 * @author simran This class is to bind the listener to all the different
 *         streams.
 */
@NoArgsConstructor
@EnableBinding({ AcademiesStream.class, ExperienceStream.class, LocationStream.class, PersonalInfoStream.class,
		ProjectStream.class, SkillsStream.class, TrainingStream.class, UserStream.class })
public class DownStreamListener {

	// Logger object
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// all the repository
	/*
	 * private AcademiesRepository academiesRepository; private ExperienceRepository
	 * experienceRepository; private LocationRepository locationRepository; private
	 * PersonalInfoRepository personalInfoRepository; private ProjectRepository
	 * projectRepository; private SkillsRepository skillsRepository; private
	 * TrainingRepository trainingRepository;
	 */
	private UserRepository userRepository;

	private Optional<User> opt;
	private User user;

	/*
	 * @Autowired public DownStreamListener(AcademiesRepository academiesRepository,
	 * ExperienceRepository experienceRepository, LocationRepository
	 * locationRepository, PersonalInfoRepository personalInfoRepository,
	 * ProjectRepository projectRepository, SkillsRepository skillsRepository,
	 * TrainingRepository trainingRepository, UserRepository userRepository, User
	 * user) {
	 * 
	 * this.academiesRepository = academiesRepository; this.experienceRepository =
	 * experienceRepository; this.locationRepository = locationRepository;
	 * this.personalInfoRepository = personalInfoRepository; this.projectRepository
	 * = projectRepository; this.skillsRepository = skillsRepository;
	 * this.trainingRepository = trainingRepository; this.userRepository =
	 * userRepository; this.user = user; }
	 */
	@Autowired
	public DownStreamListener(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@StreamListener(ExperienceStream.INPUT)
	public void experiencePost(@Payload Experience experience) {
		opt = userRepository.findById(experience.getProfileId());
		user = opt.get();
		List<Experience> list;
		if (user.getExperience() == null)
			list = new ArrayList<>();
		else
			list = user.getExperience();
		list.add(experience);
		user.setExperience(list);
		user.setUsername(experience.getProfileId());
		userRepository.save(user);
	}

	@StreamListener(AcademiesStream.INPUT)
	public void academiesPost(@Payload AcademicQualification academies) {
		/*
		 * try { academiesRepository.save(academies); } catch (Exception e) {
		 * logger.info("Error in saving"); }
		 */
		opt = userRepository.findById(academies.getProfileId());
		user = opt.get();
		List<AcademicQualification> list;
		if (user.getExperience() == null)
			list = new ArrayList<>();
		else
			list = user.getAcademics();
		list.add(academies);
		user.setAcademics(list);
		logger.info(academies.toString() + " academies");
		userRepository.save(user);
	}

	@StreamListener(LocationStream.INPUT)
	public void locationPost(@Payload Location location) {
		/*
		 * try { locationRepository.save(location); } catch (Exception e) {
		 * logger.info("Error in saving"); }
		 */
		opt = userRepository.findById(location.getProfileId());
		user = opt.get();
		List<Location> list;
		if (user.getLocation() == null)
			list = new ArrayList<>();
		else
			list = user.getLocation();

		list.add(location);
		user.setLocation(list);
		userRepository.save(user);

		logger.info(location.toString() + " location");
	}

	@StreamListener(PersonalInfoStream.INPUT)
	public void personalInfoPost(@Payload PersonalInfo personalInfo) {
		/*
		 * try { personalInfoRepository.save(personalInfo); } catch (Exception e) {
		 * logger.info("Error in saving"); }
		 */
		user.setPersonalInfo(personalInfo);
		user.setUsername(personalInfo.getProfileId());
		userRepository.save(user);

		logger.info(personalInfo.toString() + " personal info");
	}

	@StreamListener(ProjectStream.INPUT)
	public void projectPost(@Payload Projects project) {
		/*
		 * try { projectRepository.save(project); } catch (Exception e) {
		 * logger.info("Error in saving"); }
		 */
		List<Projects> list;
		opt = userRepository.findById(project.getProfileId());
		user = opt.get();

		if (user.getProject() == null)
			list = new ArrayList<>();
		else
			list = user.getProject();

		list.add(project);
		user.setProject(list);
		userRepository.save(user);
		logger.info(project.toString() + " project");
	}

	@StreamListener(SkillsStream.INPUT)
	public void skillsPost(@Payload Skills skills) {
		/*
		 * try { skillsRepository.save(skills); } catch (Exception e) {
		 * logger.info("Error in saving"); }
		 */

		opt = userRepository.findById(skills.getProfileId());
		user = opt.get();
		List<Skills> list;
		if (user.getSkills() == null)
			list = new ArrayList<>();
		else
			list = user.getSkills();

		list.add(skills);
		user.setSkills(list);
		userRepository.save(user);

		logger.info(skills.toString() + " skills");
	}

	@StreamListener(TrainingStream.INPUT)
	public void TrainingPost(@Payload Certificates certificates) {
		/*
		 * try { trainingRepository.save(training); } catch (Exception e) {
		 * logger.info("Error in saving"); }
		 */

		opt = userRepository.findById(certificates.getProfileId());
		user = opt.get();
		List<Certificates> list;
		if (user.getCertificates() == null)
			list = new ArrayList<>();
		else
			list = user.getCertificates();

		list.add(certificates);
		user.setCertificates(list);
		user.setUsername(certificates.getProfileId());
		userRepository.save(user);

		logger.info(certificates.toString() + " training");
	}

	@StreamListener(UserStream.INPUT)
	public void userPost(@Payload User user) {
		/*
		 * try { userRepository.save(user); } catch (Exception e) {
		 * logger.info("Error in saving"); }
		 */
		userRepository.save(user);
		logger.info(user.toString() + " user");
	}

}
