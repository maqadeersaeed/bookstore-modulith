UPDATE users
SET password = '$2a$10$v643/pJkjCo7o8g1Y4KYHOWUo6vfuclZftKUwncgD6dpC.xl7CNKm'
WHERE username IN (
    'admin',
    'john',
    'mary',
    'david',
    'qadeer',
    'qadeer2'
);
