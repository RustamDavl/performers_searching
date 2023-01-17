package com.rustdv.webconstruction.mapping;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdatePhotoDto;
import com.rustdv.webconstruction.entity.PhotoForResume;
import com.rustdv.webconstruction.util.ImageLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateUpdatePhotoMapper implements Mapper<CreateUpdatePhotoDto, PhotoForResume> {

    private final ImageLoader imageLoader;

    @Override
    public PhotoForResume mapFrom(CreateUpdatePhotoDto from) {
//        return PhotoForResume.builder()
//                .photo(imageLoader.savePhoto(from.getBytes()))
//                .build();
        return null;
    }
}
